package gc;

/**
 * @Described£ºÌÓÒİ·ÖÎö²âÊÔ
 * @author YHJ create at 2011-12-24 ÏÂÎç05:08:09
 * @FileNmae com.yhj.jvm.gc.finalizeEscape.FinalizedEscape.java
 */
public class FinalizedEscape {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(FinalizedEscapeTestCase.caseForEscape);
		FinalizedEscapeTestCase.caseForEscape = new FinalizedEscapeTestCase();
		System.out.println(FinalizedEscapeTestCase.caseForEscape);
		FinalizedEscapeTestCase.caseForEscape = null;
		System.gc();
		Thread.sleep(100);
		System.out.println(FinalizedEscapeTestCase.caseForEscape);
	}
}

/**
 * @Described£ºÌÓÒİ·ÖÎö²âÊÔÓÃÀı
 * @author YHJ create at 2011-12-24 ÏÂÎç05:07:05
 * @FileNmae com.yhj.jvm.gc.pojo.TestCaseForEscape.java
 */
class FinalizedEscapeTestCase {

	public static FinalizedEscapeTestCase caseForEscape = null;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("¹ş¹ş£¬ÎÒÒÑÌÓÒİ£¡");
		caseForEscape = this;
	}
}
