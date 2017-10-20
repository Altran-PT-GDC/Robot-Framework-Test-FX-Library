*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Get Selected Choicebox Item
    ${default_item}=     Set Variable     Two
    ${item}=   Get Selected Choicebox Item     \#cb
    Should Be Equal     ${item}     ${default_item}

Test Choicebox Item Should Be Selected
    ${default_item}=     Set Variable     Two
    Choicebox Item Should Be Selected       \#cb    ${default_item}
    ${item}=   Get Selected Choicebox Item     \#cb
    Should Be Equal     ${item}     ${default_item}

Test Choicebox Item Should Not Be Selected
    ${not_sel_item}=      Set Variable      One
    Choicebox Item Should Not Be Selected       \#cb    ${not_sel_item}
    ${item}=   Get Selected Choicebox Item     \#cb
    Should Not Be Equal     ${item}     ${not_sel_item}

Test Choicebox Should Be Enabled
    Choicebox Should Be Enabled      \#cb
    Verify That Is Enabled      \#cb

Test Tool Bar Should Be Disabled
    Choicebox Should Be Disabled      \#cbDisabled
    Verify That Is Disabled      \#cbDisabled