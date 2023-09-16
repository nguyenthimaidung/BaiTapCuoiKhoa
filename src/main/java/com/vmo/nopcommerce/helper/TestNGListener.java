package com.vmo.nopcommerce.helper;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("-------Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("-------Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("-------Test Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("-------Test Skip");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("-------Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
