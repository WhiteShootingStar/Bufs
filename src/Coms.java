
public enum Coms {

	WRITE(-1), READ(1);
	final int COMMAND;

	Coms(int comm) {
		COMMAND = comm;
	}
	
	public int getComm() {
		return COMMAND;
	}
}
