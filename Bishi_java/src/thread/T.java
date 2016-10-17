package thread;

public class T {
	public static void main(String args[]) {

		Thread t = new Thread() {

			public void run() {

				pong();

			}

		};
		t.run();// 如果是这行 则输出结果为：pongping
		//t.start();// 如果是这行 则输出结果为：pongping pingpong
		System.out.print("ping");
	}

	static void pong() {
		System.out.print("pong");
	}

}
