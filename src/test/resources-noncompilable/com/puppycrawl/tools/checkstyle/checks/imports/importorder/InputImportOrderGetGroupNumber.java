/*
ImportOrder
option = (default)under
groups = /javax/, sun, /^java/, org, /java/
ordered = (default)true
separated = (default)false
separatedStaticGroups = (default)false
caseSensitive = (default)true
staticGroups = (default)
sortStaticImportsAlphabetically = (default)false
useContainerOrderingForStatic = (default)false
tokens = (default)STATIC_IMPORT


*/

//non-compiled with javac: contains specially crafted set of imports for testing
package com.puppycrawl.tools.checkstyle.checks.imports.importorder;

import javax.io.File;
import sun.tools.util.ModifierFilter.ALL_ACCESS;
import java.test.javax;
import org.junit.Test;

public class InputImportOrderGetGroupNumber {
}

