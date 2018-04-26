*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Get Scroll Bar Max Value
    ${default_max}=     Set Variable    150.2
    ${max_value}=    Get Scroll Bar Max Value    \#scrollBar
    Should Be Equal     ${max_value}      ${${default_max}}

Test Get Scroll Bar Min Value
    ${default_min}=     Set Variable    10.6
    ${min_value}=    Get Scroll Bar Min Value    \#scrollBar
    Should Be Equal     ${min_value}      ${${default_min}}

Test Get Scroll Bar Value
    ${default_value}=     Set Variable    135
    ${real_value}=    Get Scroll Bar Value      \#scrollBar
    Should Be Equal     ${real_value}      ${${default_value}}

Test Set Scroll Bar Value
    ${new_value}=     Set Variable    50.8
    Set Scroll Bar Value      \#scrollBar     ${new_value}
    ${real_value}=    Get Scroll Bar Value      \#scrollBar
    Should Be Equal     ${real_value}      ${${new_value}}

Test Scroll Bar Value Should Be
    ${value}=    Get Scroll Bar Value      \#scrollBar
    Scroll Bar Value Should Be      \#scrollBar     ${value}