*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Get List Items From ComboBox
    @{cb_items}=   Set Variable    Option 1     Option 2    Option 3    Option 4    Option 5
    ${list_items}=    Get List Items From ComboBox  .combo-box
    Should Be Equal     ${list_items}   ${cb_items}

Test Get Selected Item From Combobox
    ${cb_first_item}=   Set Variable    Option 1
    ${item}=    Get Selected Item From Combobox   .combo-box
    Should Be Equal     ${item}   ${cb_first_item}

Test Select From Combo Box By Text
    ${item_to_select}=   Set Variable    Option 2
    Select From Combo Box By Text   .combo-box   Option 2
    ${item}=    Get Selected Item From Combobox   .combo-box
    Should Be Equal     ${item}   ${item_to_select}

Test Select First From Combo Box
    ${cb_first_item}=   Set Variable    Option 1
    Select First From ComboBox      .combo-box
    ${item}=    Get Selected Item From Combobox   .combo-box
    Should Be Equal     ${item}   ${cb_first_item}

Test Select From Combo Box By Position
    ${cb_third_item}=   Set Variable    Option 3
    Select From Combo Box By Position  .combo-box   2
    ${item}=    Get Selected Item From Combobox   .combo-box
    Should Be Equal     ${item}   ${cb_third_item}
