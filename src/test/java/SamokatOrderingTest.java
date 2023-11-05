import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SamokatOrderingTest extends CommonBaseTest {

// Тест заказа через кнопку в хэдере
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Симон")
                .sendClientLastName("Балабол")
                .sendDeliveryAddress("Москва")
                .selectMetroStation("Марьина Роща")
                .sendDeliveryClientPhoneNumber("83223223322")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("28.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Не опаздываете!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Все сломалось... Лучше возьму у whoosh", isDisplayed);
    }

// Тест заказа через кнопку в середине страницы 
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Кекус")
                .sendClientLastName("Мемович")
                .sendDeliveryAddress("Караганда")
                .selectMetroStation("Павелецкая")
                .sendDeliveryClientPhoneNumber("87776996969")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("13.08.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Покатаешься со мной?")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Что сломалось, нужно вызывать фиксиков", isDisplayed);
    }
}