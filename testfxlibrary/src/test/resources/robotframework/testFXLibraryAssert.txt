*** Settings ***
Library           TestFXLibrary
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***

Test Verify That Has Text
    ${text}=    Set Variable    Open New Window
    Verify That Has Text    \#btnwindow  ${text}

Test Verify That Is Enabled
    Verify That Is Enabled  \#btnwindow

Test Verify That Is Disabled
    Verify That Is Disabled  \#disableBtn

Test Component Should Be Visible
    Component Should Be Visible  \#btnwindow

Test Component Should Be Invisible
    Component Should Be Invisible   \#checkInvisible

Test Verify That Has Child
    Verify That Has Child  \#listviewsimple     \#virtual-flow