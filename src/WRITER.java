import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class WRITER {

	RandomAccessFile file;
	File fil = new File("POGCHAMP.POG");;
	Random rand = new Random();
	final int LINES = 15;
	final int BUFFER = 12;

	public WRITER() {
		if (fil.exists()) {
			fil.delete();
		}
		fil = new File("POGCHAMP.POG");
		try {
			file = new RandomAccessFile(fil, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write() {
		FileChannel channel = file.getChannel();
		try {
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER);

			while (true) {
				buffer.rewind();
				int temp = buffer.getInt();
				if (temp == Coms.READ.COMMAND) {
					buffer.rewind();
					 buffer.putInt(Coms.WRITE.COMMAND);
					buffer.putInt(rand.nextInt(1000));
					buffer.putInt(rand.nextInt(1000));

				}
				sleep();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
