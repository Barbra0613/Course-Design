package compress.lz77;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import compress.lz77.BitInputStream;
import compress.lz77.BitOutputStream;


public class LZ77 {


	public static final int MAX_WINDOW_SIZE = (1 << 12) - 1;


	public static final int LOOK_AHEAD_BUFFER_SIZE = (1 << 4) - 1;


	private int windowSize = MAX_WINDOW_SIZE;

	public LZ77(int windowSize) {
		this.windowSize = Math.min(windowSize, MAX_WINDOW_SIZE);
	}


	public void compress(String inputFileName, String outputFileName) throws IOException {
		BitOutputStream out = null;
		try {
			byte[] data = Files.readAllBytes(Paths.get(inputFileName));
			out = new BitOutputStream(new BufferedOutputStream(new FileOutputStream(outputFileName)));
			for (int i = 0; i < data.length;) {
				Match match = findMatchInSlidingWindow(data, i);
				if (match != null) {
					out.write(Boolean.TRUE);
					out.write((byte) (match.getDistance() >> 4));
					out.write((byte) (((match.getDistance() & 0x0F) << 4) | match.getLength()));
					//System.out.println("<1," + match.getDistance() + ", " + match.getLength() + ">");
					i = i + match.getLength();
				} else {
					out.write(Boolean.FALSE);
					out.write(data[i]);
					i = i + 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}


	public void decompress(String inputFileName, String outputFileName) throws IOException {
		BitInputStream inputFileStream = null;
		FileChannel outputChannel = null;
		RandomAccessFile outputFileStream = null;
		try {
			inputFileStream = new BitInputStream(new BufferedInputStream(new FileInputStream(inputFileName)));
			outputFileStream = new RandomAccessFile(outputFileName, "rw");
			outputChannel = outputFileStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1);
			try {
				while (true) {
					int flag = inputFileStream.read();
					if (flag == 0) {
						buffer.clear();
						buffer.put(inputFileStream.readByte());
						buffer.flip();
						outputChannel.write(buffer, outputChannel.size());
						outputChannel.position(outputChannel.size());
					} else {
						int byte1 = inputFileStream.read(8);
						int byte2 = inputFileStream.read(8);
						int distance = (byte1 << 4) | (byte2 >> 4);
						int length = (byte2 & 0x0f);
						for (int i = 0; i < length; i++) {
							buffer.clear();
							outputChannel.read(buffer, outputChannel.position() - distance);
							buffer.flip();
							outputChannel.write(buffer, outputChannel.size());
							outputChannel.position(outputChannel.size());
						}
					}
				}
			} catch (EOFException e) {
				// ignore. means we reached the end of the file. and we are done.
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputFileStream.close();
			outputChannel.close();
			inputFileStream.close();
		}
	}

	private Match findMatchInSlidingWindow(byte[] data, int currentIndex) {
		Match match = new Match();
		int end = Math.min(currentIndex + LOOK_AHEAD_BUFFER_SIZE, data.length + 1);
		for (int j = currentIndex + 2; j < end; j++) {
			int startIndex = Math.max(0, currentIndex - windowSize);
			byte[] bytesToMatch = Arrays.copyOfRange(data, currentIndex, j);
			for (int i = startIndex; i < currentIndex; i++) {
				int repeat = bytesToMatch.length / (currentIndex - i);
				int remaining = bytesToMatch.length % (currentIndex - i);

				byte[] tempArray = new byte[(currentIndex - i) * repeat + (i + remaining - i)];
				int m = 0;
				for (; m < repeat; m++) {
					int destPos = m * (currentIndex - i);
					System.arraycopy(data, i, tempArray, destPos, currentIndex - i);
				}
				int destPos = m * (currentIndex - i);
				System.arraycopy(data, i, tempArray, destPos, remaining);
				if (Arrays.equals(tempArray, bytesToMatch) && bytesToMatch.length > match.getLength()) {
					match.setLength(bytesToMatch.length);
					match.setDistance(currentIndex - i);
				}
			}
		}
		if (match.getLength() > 0 && match.getDistance() > 0)
			return match;
		return null;
	}

	
	public static void main(String[] args) throws IOException {

		int windowSize = 100;


		
		LZ77 lz77 = new LZ77(windowSize);
		
		System.out.println("Compression started...");
		

		System.out.println("\nDecompression started...");
		lz77.decompress("/Users/a/Desktop/hf.zip", "/Users/a/Desktop/hf1.txt");


}}
