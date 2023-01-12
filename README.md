## Automation testing stack using Java, Selenium, TestNG, and Maven. 
It consists of:
- 'Page Component Object Model' design pattern. 
-  reports, created with Allure framework. 

The target website is [ROZETKA](https://rozetka.com.ua/ua/)

Automated tests:
1. Checking sorting notebooks by the price. 
2. Checking filtering notebooks by the valid, invalid brand's name (negative test) and by the price range.
3. Checking comparing of two notebooks. 
4. Checking adding notebooks to the cart. 
5. Checking redirection to the password recovery modal from the login modal after clicking the "Нагадати пароль" button.
6. Checking the hide/show password button in the login form shows/hides the password for an odd/even number of clicks.
7. Checking redirection to the registration modal from the login modal after clicking the "Зареєструватися" button
8. Checking the error "Введено невірну адресу ел. пошти або номер телефону" in the authorization form when entering an email without a domain name

## Executing the Tests

- Run all tests:
```shell
mvn clean test
```

