# ITI_Project_Automation




├── README.md
├── src/ (33700 tokens)
    ├── main/ (26300 tokens)
    │   ├── resources/ (900 tokens)
    │   │   ├── waits.properties
    │   │   ├── seleniumGrid.properties
    │   │   ├── video.properties
    │   │   ├── META-INF/ (100 tokens)
    │   │   │   └── services/ (100 tokens)
    │   │   │   │   └── org.testng.ITestNGListener
    │   │   ├── allure.properties
    │   │   ├── environment.properties
    │   │   ├── webapp.properties
    │   │   └── log4j2.properties (300 tokens)
    │   └── java/ (25400 tokens)
    │   │   ├── drivers/ (3800 tokens)
    │   │       ├── WebDriverProvider.java
    │   │       ├── UITest.java
    │   │       ├── AbstractDriver.java (200 tokens)
    │   │       ├── Browser.java (200 tokens)
    │   │       ├── SafariFactory.java (400 tokens)
    │   │       ├── GUIDriver.java (500 tokens)
    │   │       ├── FirefoxFactory.java (700 tokens)
    │   │       ├── ChromeFactory.java (800 tokens)
    │   │       └── EdgeFactory.java (800 tokens)
    │   │   ├── pages/ (8600 tokens)
    │   │       ├── apiTesting.java
    │   │       ├── testCases.java
    │   │       ├── contactUs.java
    │   │       ├── deleteAccount.java
    │   │       ├── logout.java
    │   │       ├── PaymentPage.java (600 tokens)
    │   │       ├── ProductDetailsPage.java (600 tokens)
    │   │       ├── cartPage.java (700 tokens)
    │   │       ├── components/ (1000 tokens)
    │   │       │   └── NavigationBarComponent.java (1000 tokens)
    │   │       ├── SignupPage.java (1100 tokens)
    │   │       ├── productsPage.java (1200 tokens)
    │   │       ├── SignupLoginPage.java (1300 tokens)
    │   │       └── CheckOutPage.java (1600 tokens)
    │   │   ├── utils/ (8200 tokens)
    │   │       ├── OSUtils.java
    │   │       ├── TimeManager.java (200 tokens)
    │   │       ├── TerminalUtils.java (200 tokens)
    │   │       ├── report/ (3100 tokens)
    │   │       │   ├── AllureEnvironmentManager.java (300 tokens)
    │   │       │   ├── AllureConstants.java (400 tokens)
    │   │       │   ├── AllureAttachmentManager.java (500 tokens)
    │   │       │   ├── AllureReportGenerator.java (700 tokens)
    │   │       │   └── AllureBinaryManager.java (1200 tokens)
    │   │       ├── logs/ (300 tokens)
    │   │       │   └── LogsManager.java (300 tokens)
    │   │       ├── WaitManager.java (300 tokens)
    │   │       ├── actions/ (3000 tokens)
    │   │       │   ├── BrowserActions.java (400 tokens)
    │   │       │   ├── AlertActions.java (600 tokens)
    │   │       │   ├── FrameActions.java (600 tokens)
    │   │       │   └── ElementActions.java (1400 tokens)
    │   │       └── dataReader/ (1000 tokens)
    │   │       │   ├── PropertyReader.java (400 tokens)
    │   │       │   └── JsonReader.java (600 tokens)
    │   │   ├── validations/ (1300 tokens)
    │   │       ├── Verification.java (200 tokens)
    │   │       ├── Validation.java (500 tokens)
    │   │       └── BaseAssertion.java (600 tokens)
    │   │   ├── media/ (1500 tokens)
    │   │       ├── ScreenshotsManager.java (500 tokens)
    │   │       └── ScreenRecordManager.java (1000 tokens)
    │   │   ├── FileUtilss/ (700 tokens)
    │   │       └── FileUtils.java (700 tokens)
    │   │   └── listeners/ (1300 tokens)
    │   │       └── TestNGListeners.java (1300 tokens)
    └── test/ (7400 tokens)
    │   ├── resources/ (1600 tokens)
    │       └── test-data/ (1600 tokens)
    │       │   ├── ProductDetails-data.json
    │       │   ├── Login-data.json (200 tokens)
    │       │   ├── Cart-data.json (200 tokens)
    │       │   ├── CheckOut-data.json (200 tokens)
    │       │   ├── Register-data.json (300 tokens)
    │       │   ├── Products-data.json (300 tokens)
    │       │   └── Payment-data.json (300 tokens)
    │   └── java/ (5800 tokens)
    │       └── tests/ (5800 tokens)
    │           ├── BaseTest.java
    │           ├── ProductDetailsTest.java (400 tokens)
    │           ├── CartTest.java (400 tokens)
    │           ├── LoginTest.java (500 tokens)
    │           ├── ProductsTest.java (600 tokens)
    │           ├── CheckOutTest.java (1100 tokens)
    │           ├── RegisterTest.java (1200 tokens)
    │           └── PaymentTest.java (1500 tokens)
├── automationExercise.eml
├── .github/ (300 tokens)
    └── workflows/ (300 tokens)
    │   └── All test Pipeline .yml (300 tokens)
└── pom.xml (1700 tokens)
