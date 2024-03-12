/*
com.puppycrawl.tools.checkstyle.checks.javadoc.AbstractJavadocCheckTest$NonTightHtmlTagCheck

*/

package com.puppycrawl.tools.checkstyle.checks.javadoc.abstractjavadoc;

/**
 * <body>
 * <p> This class is only meant for testing. </p>
 * <p> In html, closing all tags is not necessary.
 * <li> neither is opening every tag <p> </li>
 * </body>
 *
 * @see "https://www.w3.org/TR/html51/syntax.html#optional-start-and-end-tags"
 */
public class InputAbstractJavadocNonTightHtmlTagsNoViolationOne {
    /** <p> <p> paraception </p> </p> */
    private int field1;

    /**<li> paraTags should be opened</p> list isn't nested in parse tree </li>*/
    private int field2;

    /**
     * <p> this paragraph is closed and would be nested in javadoc tree </p>
     * <li> this list has an <p> unclosed para, but still the list would get nested </li>
     */
    private int field3;

    /**
     * <li> Complete <p> nesting </p> </li>
     * <tr> Zero </p> nesting despite `tr` is closed </tr>
     */

    int getField1() {return field1;}

    /***/
    int getField2() {return field2;} //method with empty javadoc

    /**
     * <tr> <li> list is going to be nested in the parse tree </li> </tr>
     *
     * @param field1 {@code <p> paraTag will not be recognized} in javadoc tree </p>
     */
    void setField1(int field1) {this.field1 = field1;}

    /**
     * <p>This is a setter method.
     * And paraTag shall be nested in parse tree </p>
     * @param field2 <p> setter
     */
    void setField2(int field2) {this.field2 = field2;}

    /**
     * <p> paragraph with a <br>singletonElement. <hr> And it contains another one. </p>
     * <li> List with singletonElement
     * <param name=mov value="~/imitation game.mp4"> <param name=allowfullscreen value=true> </li>
     * @return <tr> tr with <base href="www.something.com"> singletonElement </tr>
     *     <tr> nonTight </th>
     */
    private int getField3() {return field3;}

    /**
     * @param field3 <td> td with singletonElement <br/> </td>
     */
    private void setField3(int field3) { this.field3 = field3;}

    /**
     * <html> <bR> <Br> <BR> <Br/> <BR/> <bR/> </html>
     * <option> <INPut/> </option>
     * @return <tbody> <input/> <br> </tbody>
     */
}
