///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2024 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package org.checkstyle.suppressionxpathfilter;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.checks.annotation.AnnotationUseStyleCheck;

public class XpathRegressionAnnotationUseStyleTest extends AbstractXpathTestSupport {

    private final String checkName = AnnotationUseStyleCheck.class.getSimpleName();

    @Override
    protected String getCheckName() {
        return checkName;
    }

    @Test
    public void testOne() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleOne.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        final String[] expectedViolation = {
            "4:1: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_INCORRECT_STYLE,
                    "COMPACT_NO_ARRAY"),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleOne']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleOne']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testTwo() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleTwo.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("closingParens", "ALWAYS");
        moduleConfig.addProperty("elementStyle", "ignore");
        moduleConfig.addProperty("trailingArrayComma", "ignore");

        final String[] expectedViolation = {
            "3:1: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_PARENS_MISSING),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleTwo']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleTwo']]"
                        + "/MODIFIERS",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleTwo']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='Deprecated']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleTwo']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='Deprecated']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testThree() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleThree.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("trailingArrayComma", "ignore");

        final String[] expectedViolation = {
            "4:5: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_INCORRECT_STYLE,
                    "COMPACT_NO_ARRAY"),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleThree']]"
                        + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='foo']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleThree']]"
                        + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='foo']]/MODIFIERS",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleThree']]"
                        + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='foo']]/MODIFIERS"
                        + "/ANNOTATION[./IDENT[@text='SuppressWarnings']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleThree']]"
                        + "/OBJBLOCK/METHOD_DEF[./IDENT[@text='foo']]/MODIFIERS"
                        + "/ANNOTATION[./IDENT[@text='SuppressWarnings']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testFour() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleFour.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("closingParens", "ignore");
        moduleConfig.addProperty("elementStyle", "ignore");
        moduleConfig.addProperty("trailingArrayComma", "ALWAYS");

        final String[] expectedViolation = {
            "3:20: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_TRAILING_COMMA_MISSING),
        };

        final List<String> expectedXpathQueries = Collections.singletonList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleFour']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]"
                        + "/ANNOTATION_ARRAY_INIT/RCURLY"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testFive() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleFive.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("closingParens", "ignore");
        moduleConfig.addProperty("elementStyle", "COMPACT");
        moduleConfig.addProperty("trailingArrayComma", "ignore");

        final String[] expectedViolation = {
            "3:1: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_INCORRECT_STYLE,
                    "COMPACT"),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleFive']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleFive']]"
                         + "/MODIFIERS",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleFive']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleFive']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testSix() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleSix.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("closingParens", "ignore");
        moduleConfig.addProperty("elementStyle", "EXPANDED");
        moduleConfig.addProperty("trailingArrayComma", "ignore");

        final String[] expectedViolation = {
            "3:1: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_INCORRECT_STYLE,
                    "EXPANDED"),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSix']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSix']]"
                        + "/MODIFIERS",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSix']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSix']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testSeven() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleSeven.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        final String[] expectedViolation = {
            "4:1: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_INCORRECT_STYLE,
                    "COMPACT_NO_ARRAY"),
        };

        final List<String> expectedXpathQueries = Arrays.asList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSeven']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]",
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleSeven']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]/AT"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }

    @Test
    public void testEight() throws Exception {
        final File fileToProcess = new File(getPath(
                "SuppressionXpathRegressionAnnotationUseStyleEight.java"));

        final DefaultConfiguration moduleConfig =
                createModuleConfig(AnnotationUseStyleCheck.class);

        moduleConfig.addProperty("closingParens", "ignore");
        moduleConfig.addProperty("elementStyle", "ignore");
        moduleConfig.addProperty("trailingArrayComma", "NEVER");

        final String[] expectedViolation = {
            "3:31: " + getCheckMessage(AnnotationUseStyleCheck.class,
                    AnnotationUseStyleCheck.MSG_KEY_ANNOTATION_TRAILING_COMMA_PRESENT),
        };

        final List<String> expectedXpathQueries = Collections.singletonList(
                "/COMPILATION_UNIT/CLASS_DEF"
                        + "[./IDENT[@text='SuppressionXpathRegressionAnnotationUseStyleEight']]"
                        + "/MODIFIERS/ANNOTATION[./IDENT[@text='SuppressWarnings']]"
                        + "/ANNOTATION_ARRAY_INIT/COMMA"
        );

        runVerifications(moduleConfig, fileToProcess, expectedViolation,
                expectedXpathQueries);
    }
}
