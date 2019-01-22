*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Select Tree Node By Index
    Select Tree Node By Index   \#treeView   1

Test Clear Tree Selection
    Select Tree Node By Index   \#treeView  2
    Clear Tree Selection   \#treeView

Test Unselect Tree Node By Index
    Select Tree Node By Index   \#treeView  2
    Select Tree Node By Index   \#treeView  3
    Unselect Tree Node By Index   \#treeView  2

Test Get Selected TreeView Nodes
    Select Tree Node By Index   \#treeView  2
    @{selected_nodes}=    Set Variable     Message2     Message3
    @{nodes}=   Get Selected TreeView Nodes     \#treeView
    Should Be Equal     ${nodes}      ${selected_nodes}

Test Select TreeView Node By Text
    ${new_selection}=     Set Variable   Message5
    Select TreeView Node By Text    \#treeView     ${new_selection}
    @{nodes}=   Get Selected TreeView Nodes     \#treeView
    Should Contain     ${nodes}      ${new_selection}

Test Collapse Tree Node
    Collapse Tree Node     \#treeView

Test TreeView Should Be Enabled
    TreeView Should Be Enabled     \#treeView
    ${attribute}=   Set Variable    isDisable
    ${status}=   Get Component Attribute    \#treeView    ${attribute}
    Should Be True    ${${status}}==${FALSE}

Test TreeView Should Be Disabled
    TreeView Should Be Disabled     \#treeViewDisabled
    ${attribute}=   Set Variable    isDisable
    ${status}=   Get Component Attribute    \#treeViewDisabled    ${attribute}
    Should Be True    ${${status}}==${TRUE}
