package thread;

public class T {
	public static void main(String args[]) {

		Thread t = new Thread() {

			public void run() {

				pong();

			}

		};
		t.run();// ��������� ��������Ϊ��pongping
		//t.start();// ��������� ��������Ϊ��pongping pingpong
		System.out.print("ping");
	}

	static void pong() {
		System.out.print("pong");
	}

}
