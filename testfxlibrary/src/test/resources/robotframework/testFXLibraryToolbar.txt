*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***
Test Get Tool Bar Items
    @{default_items}=    Set Variable     Button[id=btnToolBarOk, styleClass=button]'OK'      Button[id=btnToolBarCancel, styleClass=button]'Cancel'
    @{toolbar_items}=   Get Tool Bar Items    \#toolbar
    Should Be Equal     ${toolbar_items}        ${default_items}

Test Tool Bar Should Be Enabled
    Tool Bar Should Be Enabled      \#toolbar
    Verify That Is Enabled      \#toolbar

Test Tool Bar Should Be Disabled
    Tool Bar Should Be Disabled      \#toolbarDisabled
    Verify That Is Disabled      \#toolbarDisabled