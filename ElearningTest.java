package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElearningTest {
    public static void main(String[] args) throws InterruptedException {
        // ตั้งค่าเส้นทางของ ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        // สร้าง instance ของ WebDriver
        WebDriver driver = new ChromeDriver();

        // เปิดเว็บไซต์ eLearning
        driver.get("https://elearning2.sut.ac.th/");
        System.out.println("Page title is: " + driver.getTitle());

        // รอให้ปุ่มล็อกอินปรากฏ
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='log in']")));
        loginButton.click();
        System.out.println("Login page is displayed.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000); 

        // รอให้หน้าเข้าสู่ระบบปรากฏ
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        // กรอกข้อมูลชื่อผู้ใช้และรหัสผ่าน
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("B6601775");
        passwordField.sendKeys("1309903167321");

        // คลิกที่ปุ่ม "เข้าสู่ระบบ"
        WebElement loginSubmitButton = driver.findElement(By.id("loginbtn"));
        loginSubmitButton.click();
        System.out.println("Logged in successfully!");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        // รอให้ช่องค้นหาปรากฏและกรอกคำค้นหา
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("1101160");
        searchBox.submit();
        System.out.println("Search for '1101160' has been successfully submitted.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        // รอให้ผลลัพธ์การค้นหาปรากฏ
        WebElement courseBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='coursebox clearfix odd first last']")));
        WebElement courseLink = courseBox.findElement(By.xpath(".//a[@class='aalink']"));
        courseLink.click();
        System.out.println("Course link clicked successfully.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        WebElement course63 = driver.findElement(By.xpath("//a[contains(text(),'1101163 Project in Software Engineering')]"));
        course63.click();
        System.out.println("Selected course '1101163 Project in Software Engineering'.");

        WebElement course63work = driver.findElement(By.xpath("//span[@class='instancename'][contains(text(),'W11: User Acceptance Test (UAT)')]"));
        course63work.click();
        System.out.println("Selected assignment 'W11: User Acceptance Test (UAT)'.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        WebElement addSubmissionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Edit assignment')]")));
        addSubmissionButton.click();
        System.out.println("Edit assignment button clicked.");

        WebElement addLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Add...']")));
        addLink.click();
        System.out.println("Add file link clicked.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        // รอให้ฟิลด์อัพโหลดไฟล์ปรากฏและอัปโหลดไฟล์
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("repo_upload_file")));
        String filePath = "C:\\Users\\HP\\Downloads\\G20_UAT.xlsx";
        fileInput.sendKeys(filePath);
        System.out.println("File selected for upload: " + filePath);

        // รอให้ปุ่ม "Upload this file" ปรากฏ
        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("fp-upload-btn")));
        uploadButton.click();
        System.out.println("File uploaded successfully.");

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        // รอให้ปุ่ม "Save changes" ปรากฏ
        WebElement saveChangesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_submitbutton")));
        saveChangesButton.click();
        System.out.println("Changes saved successfully.");

        // รอให้ชื่อคอร์สปรากฏในหน้า
        WebElement courseTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        System.out.println("Course title is: " + courseTitle.getText());

        // เพิ่มเวลาหยุด 2 วินาที
        Thread.sleep(2000);

        // รอให้เมนูผู้ใช้ปรากฏและคลิกที่เมนู
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("action-menu-toggle-1")));
        userMenu.click();
        System.out.println("User menu opened.");

        // รอให้ปุ่ม "Log out" ปรากฏและคลิก
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
        logoutButton.click();
        System.out.println("Logged out successfully!");

        // รอให้กลับมาที่หน้าเข้าสู่ระบบ
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainindex")));
        System.out.println("Back to login page.");

        // ปิดเบราว์เซอร์
        driver.quit();
    }
}
