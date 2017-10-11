package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RobotKeywords
public class DatePicker {

    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns the date selected in a DatePicker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the DatePicker component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  The date Selected on the DatePicker
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#datePicker</td>
     *         <td>Get Selected Datepicker Date</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedDatepickerDate(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.DatePicker datePicker = TestFxLibraryCommon.lookup(identifier);

        try {

            LocalDate localDate = datePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            return date.toString();

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword sets the date in the DatePicker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the DatePicker component
     * @param date
     * : the date you want to set on the DatePicker component. The Date must be in the dd-mm-yyyy format.
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>date</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#datePicker</td>
     *         <td>Set Datepicker Date</td>
     *         <td>01-01-2017</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "date"})
    public void setDatepickerDate(String identifier, String date){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.DatePicker datePicker = TestFxLibraryCommon.lookup(identifier);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            datePicker.setValue(localDate);

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword sets the date in the DatePicker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the DatePicker component
     * @param dateToValidate
     * : the date you want to Check on the DatePicker component. The Date must be in the dd-mm-yyyy format.
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>dateToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#datePicker</td>
     *         <td>Datepicker Date Should Be</td>
     *         <td>01-01-2017</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "dateToValidate"})
    public void datepickerDateShouldBe(String identifier, String dateToValidate){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        String date = getSelectedDatepickerDate(identifier);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(dateToValidate, formatter);
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date finalDateToValidate = Date.from(instant);
            if(!finalDateToValidate.toString().equals(date)){
            throw new TestFxLibraryFatalException("The date " + date + " doesn't match the specified date "+ finalDateToValidate.toString() +" .");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
