*** Settings ***

Library  Selenium2Library
Library  BuiltIn
Library  String
Library  DateTime
Documentation
...    Selenium tests


*** Variables ***

${Browser}  Chrome
${URL}  http://automationpractice.com/index.php


*** Test Cases ***

TC_001 Invalid Sign in
    Open Browser  ${URL}  ${Browser}
    Click Link  link=Sign in

    Title Should Be  Login - My Store
    Input Text  id=email  dsfdsgdsfds@fdsfds.com
    Input Text  id=passwd  invalid_password
    Click Button  id=SubmitLogin

    Page Should Contain  Authentication failed

    Close Browser

TC_002 Sign in
    Open Browser  ${URL}  ${Browser}
    Click Link  link=Sign in

    Title Should Be  Login - My Store
    Input Text  id=email  dsfdsgdsfds@fdsfds.com
    Input Text  id=passwd  password
    Click Button  id=SubmitLogin

    Page Should Contain  Welcome to your account

    Close Browser

TC_003 Invalid register
    Open Browser  ${URL}  ${Browser}
    Click Link  link=Sign in

    Title Should Be  Login - My Store
    Input Text  id=email_create  dsfdsgdsfds@fdsfds.com
    Click Button  id=SubmitCreate

    Wait Until Element Is Visible  id=create_account_error  timeout=5
    Page Should Contain  An account using this email address has already been registered

    Close Browser

TC_004 Register
    ${epoch} =  Get Current Date  result_format=epoch  exclude_millis=true
    ${email} =  Catenate  SEPARATOR=  robot.  ${epoch}  @example.com
    ${password} =  Set Variable  password

    Log Variables

    Open Browser  ${URL}  ${Browser}
    Click Link  link=Sign in

    Title Should Be  Login - My Store
    Input Text  id=email_create  ${email}
    Click Button  id=SubmitCreate

    Wait Until Element Is Visible  id=customer_firstname  timeout=5

    Input Text  id=customer_firstname  Test
    Input Text  id=customer_lastname  Test
    Input Text  id=passwd  ${password}
    Input Text  id=firstname  Test
    Input Text  id=lastname  Test
    Input Text  id=address1  Test
    Input Text  id=city  Test
    Input Text  id=postcode  12345
    Input Text  id=phone_mobile  123456789
    Select From List By Index  id=id_state  1

    Click Button  id=submitAccount

    Page Should Contain  Welcome to your account

    Close Browser
