*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***
Test Spinner Get Value
    ${default_value}=   Set Variable    100
    ${real_value}=      Spinner Get Value    \#spinner
    Should Be Equal     ${real_value}   ${${default_value}}

Test Spinner Set Value
    ${new_value}=   Set Variable    200
    Spinner Set Value    \#spinner    ${new_value}
    ${real_value}=      Spinner Get Value    \#spinner
    Should Be Equal     ${real_value}   ${${new_value}}

Test Spinner Increment
    ${default_value}=      Spinner Get Value    \#spinner
    ${increment_value}=     Set Variable    1
    Spinner Increment    \#spinner      ${increment_value}
    ${current_value}=      Spinner Get Value    \#spinner
    Should Be Equal     ${current_value}   ${${default_value}+${increment_value}}

Test Spinner Decrement
    ${default_value}=      Spinner Get Value    \#spinner
    ${decrement_value}=     Set Variable    1
    Spinner Decrement    \#spinner      1
    ${current_value}=      Spinner Get Value    \#spinner
    Should Be Equal     ${current_value}   ${${default_value}-${decrement_value}}

Test Spinner Value Should Be
    ${default_value}=      Spinner Get Value    \#spinner
    Spinner Value Should Be    \#spinner      ${default_value}
    ${current_value}=      Spinner Get Value    \#spinner
    Should Be Equal     ${current_value}   ${${default_value}}
