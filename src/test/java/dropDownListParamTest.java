import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

//Параметризованный тест соответствия текста в выпадающем списке ожидаемому тексту
@RunWith(Parameterized.class)
public class dropDownListParamTest extends commonBaseTest {

    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;


//Конструктор класса
    public dropDownListParamTest(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

//Массив с текстом ожидаемых ответов
    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        MainPage mainPage = new MainPage(driver);
        return new Object[][]{
                {mainPage.dropDownQuestionsArray[0], mainPage.dropDownAnswersArray[0], mainPage.expectedResponsesArray[0]},
                {mainPage.dropDownQuestionsArray[1], mainPage.dropDownAnswersArray[1], mainPage.expectedResponsesArray[1]},
                {mainPage.dropDownQuestionsArray[2], mainPage.dropDownAnswersArray[2], mainPage.expectedResponsesArray[2]},
                {mainPage.dropDownQuestionsArray[3], mainPage.dropDownAnswersArray[3], mainPage.expectedResponsesArray[3]},
                {mainPage.dropDownQuestionsArray[4], mainPage.dropDownAnswersArray[4], mainPage.expectedResponsesArray[4]},
                {mainPage.dropDownQuestionsArray[5], mainPage.dropDownAnswersArray[5], mainPage.expectedResponsesArray[5]},
                {mainPage.dropDownQuestionsArray[6], mainPage.dropDownAnswersArray[6], mainPage.expectedResponsesArray[6]},
                {mainPage.dropDownQuestionsArray[7], mainPage.dropDownAnswersArray[7], mainPage.expectedResponsesArray[7]},
        };
    }
//Сравнение текста ответа с эталонным текстом
    @Test
    public void dropDownListTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToEndOfList()
                .clickQuestionButton(questionLocator);

        new MainPage(driver);
        String ActualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, ActualAnswerText);
    }
}