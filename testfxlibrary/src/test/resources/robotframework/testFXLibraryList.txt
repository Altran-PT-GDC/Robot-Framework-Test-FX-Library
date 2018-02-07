*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Get List Items From ListView
    @{default_list_items}=      Set Variable    one     two     three      four     five    six     seven   eight
    @{list_items}=    Get List Items From ListView  \#listviewsimple
    :FOR    ${item}    IN    @{list_items}
    \    Should Contain     "${default_list_items}"     ${item}

Test Get Selected Items From List
    ${default_list_item}=   Set Variable    one
    ${selected_item}=   Get Selected Items From List    \#listviewsimple
    Should Contain     "${selected_item}"    ${default_list_item}

Test Clear Selection From List
    ${no_items}=    Set Variable    0
    Clear Selection From List     \#listviewsimple
    ${list_item_count}=     Get List Item Count From List   \#listviewsimple
    Should Be Equal     ${list_item_count}      ${${no_items}}

Test Select From List View By Text
    Clear Selection From List     \#listviewsimple
    ${item_search}=     Set Variable    three
    Select From List View By Text  \#listviewsimple   ${item_search}
    ${selected_item}=   Get Selected Items From List    \#listviewsimple
    Should Contain     "${selected_item}"   ${item_search}

Test Select From List View By Position
    Clear Selection From List     \#listviewsimple
    ${item_name}=   Set Variable    six
    ${position}=    Set Variable    5
    Select From List View By Position  \#listviewsimple   ${position}
    ${selected_item}=   Get Selected Items From List    \#listviewsimple
    Should Contain     "${selected_item}"   ${item_name}

Test Get List Item Count From List
    ${default_count}=   Set Variable    2
    ${list_item_count}=     Get List Item Count From List   \#listviewsimple
    Should Be Equal     ${list_item_count}      ${${default_count}}

Test Unselect From List By Position
    ${no_items}=    Set Variable    0
    ${unselected_item}=     Set Variable    0
    Unselect From List By Position    \#listviewsimple      3
    Unselect From List By Position    \#listviewsimple      5
    ${list_item_count}=     Get List Item Count From List   \#listviewsimple
    Should Be Equal     ${list_item_count}      ${${no_items}}

Test Unselect From List By Text
    ${default_count}=    Set Variable    1
    ${first_item}=    Set Variable    one
    ${position}=     Set Variable    0
    Select From List View By Position  \#listviewsimple   ${position}
    Unselect From List By Text    \#listviewsimple      ${first_item}
    ${list_item_count}=     Get List Item Count From List   \#listviewsimple
    Should Be Equal     ${list_item_count}      ${${default_count}}

Test List View Should Contain
    ${item_in_list}=    Set Variable    five
    List View Should Contain    \#listviewsimple    ${item_in_list}
    ${all_list_items}=    Get List Items From ListView      \#listviewsimple
    Should Contain      "${all_list_items}"       ${item_in_list}

Test List View Should Not Contain
    ${item_not_in_list}=    Set Variable    nine
    List View Should Not Contain    \#listviewsimple    ${item_not_in_list}
    ${all_list_items}=    Get List Items From ListView      \#listviewsimple
    Should Not Contain      "${all_list_items}"       ${item_not_in_list}

Test List Selection Should Be
    Clear Selection From List     \#listviewsimple
    ${items_selection}=    Set Variable    two//three//five
    @{should_be_selected}=      Set Variable    two     three    five
    Select Items From List View     \#listviewsimple    ${items_selection}
    ${selected_items}=   Get Selected Items From List   \#listviewsimple
    :FOR    ${item}    IN    @{should_be_selected}
    \    Should Contain     "${selected_items}"     ${item}

Test Select Items From List View
    Clear Selection From List     \#listviewsimple
    ${item}=    Set Variable    six
    Select Items From List View     \#listviewsimple    ${item}
    ${selected_items}=   Get Selected Items From List   \#listviewsimple
    Should Contain     "${selected_items}"     ${item}
