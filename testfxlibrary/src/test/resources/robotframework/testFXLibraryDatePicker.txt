*** Settings ***
Library           TestFXLibrary
Library           DateTime
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***
Test Datepicker Date Should Be
    ${default_date}=    Set Variable    10-10-2017
    Datepicker Date Should Be      \#datePicker     ${default_date}

Test Get Selected Datepicker Date
    ${default_date}=    Set Variable    Tue Oct 10
    ${get_date}=      Get Selected Datepicker Date      \#datePicker
    Should Contain     ${get_date}     ${default_date}

Test Set Datepicker Date
    ${new_date}=    Set Variable    01-01-2017
    Set Datepicker Date      \#datePicker     ${new_date}
    Datepicker Date Should Be      \#datePicker     ${new_date}

