package com.bdd.pom.authentication.pageelements;

import org.openqa.selenium.By;

public class OrderConfirmationPageElements {

    public static By paymentinfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]");

    public static By shippinginfo = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");

    public static By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");

    public static By finishButton = By.id("finish");
}
