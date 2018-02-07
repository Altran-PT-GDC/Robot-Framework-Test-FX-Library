*** Settings ***
Library           TestFXLibrary

*** Test Cases ***
Test Set Timeout
    Start Application  testapp.FxApplicationUnitTest
    Set Timeout     newtimeout      20
    Close Application