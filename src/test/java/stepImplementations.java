import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class stepImplementations extends baseTest {
    @Step("Ana sayfaya git")
    public void anaSayfa() {
        getUrl();
        System.out.println("Ana sayfa yuklendi.");
    }

    @Step("<saniye> sn. bekle")
    public void waitElement(int key) throws InterruptedException {
        Thread.sleep(key * 1000);
        System.out.println(key + " saniye beklendi.");
    }

    @Step("<element> tikla")
    public void clickStep(String element) {
        clickElement(element);
        System.out.println(element + " tiklandi.");
    }

    @Step("<hoverElement> uzerinde bekle")
    public void hoverStep(String hoverElement) {
        hoverElement(hoverElement);
        System.out.println(hoverElement + " uzerinde beklendi.");
    }

    @Step("<checkElement> kontrol et")
    public void checkStep(String element) {
        try {
            findElement(element);
            System.out.println(element + " kontrol edildi.");
        } catch (Exception e) {
            Assert.fail("Element bulunamadi.");
        }
    }

    @Step("yeni pencereye kay")
    public void newTab() {
        openNewTab();
        System.out.println("Yeni pencerede devam edildi.");
    }
}
