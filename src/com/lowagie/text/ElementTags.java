/*
 * $Id$
 * $Name$
 *
 * Copyright (c) 2001, 2002 Bruno Lowagie.
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the License.
 *
 * The Original Code is 'iText, a free JAVA-PDF library'.
 *
 * The Initial Developer of the Original Code is Bruno Lowagie. Portions created by
 * the Initial Developer are Copyright (C) 1999, 2000, 2001, 2002 by Bruno Lowagie.
 * All Rights Reserved.
 * Co-Developer of the code is Paulo Soares. Portions created by the Co-Developer
 * are Copyright (C) 2000, 2001, 2002 by Paulo Soares. All Rights Reserved.
 *
 * Contributor(s): all the names of the contributors are added in the source code
 * where applicable.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * LGPL license (the "GNU LIBRARY GENERAL PUBLIC LICENSE"), in which case the
 * provisions of LGPL are applicable instead of those above.  If you wish to
 * allow use of your version of this file only under the terms of the LGPL
 * License and not to allow others to use your version of this file under
 * the MPL, indicate your decision by deleting the provisions above and
 * replace them with the notice and other provisions required by the LGPL.
 * If you do not delete the provisions above, a recipient may use your version
 * of this file under either the MPL or the GNU LIBRARY GENERAL PUBLIC LICENSE.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the MPL as stated above or under the terms of the GNU
 * Library General Public License as published by the Free Software Foundation;
 * either version 2 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Library general Public License for more
 * details.
 *
 * If you didn't download this code from the following link, you should check if
 * you aren't using an obsolete version:
 * http://www.lowagie.com/iText/
 */

package com.lowagie.text;

import java.awt.Color;

/**
 * A class that contains all the possible tagnames and their attributes.
 */

public class ElementTags {
    
/** the root tag. */
    public static final String ITEXT = "itext";
    
/** attribute of the root and annotation tag (also a special tag within a chapter or section) */
    public static final String TITLE = "title";
    
/** attribute of the root tag */
    public static final String SUBJECT = "subject";
    
/** attribute of the root tag */
    public static final String KEYWORDS = "keywords";
    
/** attribute of the root tag */
    public static final String AUTHOR = "author";
    
/** attribute of the root tag */
    public static final String CREATIONDATE = "creationdate";
    
/** attribute of the root tag */
    public static final String PRODUCER = "producer";
    
    // Chapters and Sections
    
/** the chapter tag */
    public static final String CHAPTER = "chapter";
    
/** the section tag */
    public static final String SECTION = "section";
    
/** attribute of section/chapter tag */
    public static final String NUMBERDEPTH = "numberdepth";
    
/** attribute of section/chapter tag */
    public static final String DEPTH = "depth";
    
/** attribute of section/chapter tag */
    public static final String NUMBER = "number";
    
/** attribute of section/chapter tag */
    public static final String INDENT = "indent";
    
/** attribute of chapter/section/paragraph/table/cell tag */
    public static final String LEFT = "left";
    
/** attribute of chapter/section/paragraph/table/cell tag */
    public static final String RIGHT = "right";
    
    // Phrases, Anchors, Lists and Paragraphs
    
/** the phrase tag */
    public static final String PHRASE = "phrase";
    
/** the anchor tag */
    public static final String ANCHOR = "anchor";
    
/** the list tag */
    public static final String LIST = "list";
    
/** the listitem tag */
    public static final String LISTITEM = "listitem";
    
/** the paragraph tag */
    public static final String PARAGRAPH = "paragraph";
    
/** attribute of phrase/paragraph/cell tag */
    public static final String LEADING = "leading";
    
/** attribute of paragraph/image/table tag */
    public static final String ALIGN = "align";
    
/** attribute of paragraph */
    public static final String KEEPTOGETHER = "keeptogether";
    
/** attribute of anchor tag */
    public static final String NAME = "name";
    
/** attribute of anchor tag */
    public static final String REFERENCE = "reference";
    
/** attribute of list tag */
    public static final String LISTSYMBOL = "listsymbol";
    
/** attribute of list tag */
    public static final String NUMBERED = "numbered";
    
/** attribute of the list tag */
    public static final String LETTERED = "lettered";

/** attribute of list tag */
    public static final String FIRST = "first";
    
/** attribute of list tag */
    public static final String SYMBOLINDENT = "symbolindent";
    
/** attribute of list tag */
    public static final String INDENTATIONLEFT = "indentationleft";
    
/** attribute of list tag */
    public static final String INDENTATIONRIGHT = "indentationright";
    
    // Chunks
    
/** the chunk tag */
    public static final String IGNORE = "ignore";
    
/** the chunk tag */
    public static final String ENTITY = "entity";
    
/** the chunk tag */
    public static final String ID = "id";
    
/** the chunk tag */
    public static final String CHUNK = "chunk";
    
/** attribute of the chunk tag */
    public static final String FONT = "font";
    
/** attribute of the chunk tag */
    public static final String ENCODING = "encoding";
    
/** attribute of the chunk tag */
    public static final String EMBEDDED = "embedded";
    
/** attribute of the chunk tag */
    public static final String SIZE = "size";
    
/** attribute of the chunk tag */
    public static final String STYLE = "style";
    
/** attribute of the chunk/table/cell tag */
    public static final String COLOR = "color";
    
/** attribute of the chunk/table/cell tag */
    public static final String RED = "red";
    
/** attribute of the chunk/table/cell tag */
    public static final String GREEN = "green";
    
/** attribute of the chunk/table/cell tag */
    public static final String BLUE = "blue";
    
/** attribute of the chunk tag */
    public static final String SUBSUPSCRIPT = Chunk.SUBSUPSCRIPT.toLowerCase();
    
/** attribute of the chunk tag */
    public static final String LOCALGOTO = Chunk.LOCALGOTO.toLowerCase();
    
/** attribute of the chunk tag */
    public static final String REMOTEGOTO = Chunk.REMOTEGOTO.toLowerCase();
    
/** attribute of the chunk tag */
    public static final String LOCALDESTINATION = Chunk.LOCALDESTINATION.toLowerCase();
    
/** attribute of the chunk tag */
    public static final String GENERICTAG = Chunk.GENERICTAG.toLowerCase();
    
    // tables/cells
    
/** the table tag */
    public static final String TABLE = "table";
    
/** the cell tag */
    public static final String ROW = "row";
    
/** the cell tag */
    public static final String CELL = "cell";
    
/** attribute of the table tag */
    public static final String COLUMNS = "columns";
    
/** attribute of the table tag */
    public static final String LASTHEADERROW = "lastHeaderRow";
    
/** attribute of the table tag */
    public static final String CELLPADDING = "cellpadding";
    
/** attribute of the table tag */
    public static final String CELLSPACING = "cellspacing";
    
/** attribute of the table tag */
    public static final String OFFSET = "offset";
    
/** attribute of the table tag */
    public static final String WIDTHS = "widths";
    
/** attribute of the table tag */
    public static final String TABLEFITSPAGE = "tablefitspage";
    
/** attribute of the table tag */
    public static final String CELLSFITPAGE = "cellsfitpage";
    
/** attribute of the cell tag */
    public static final String HORIZONTALALIGN = "horizontalalign";
    
/** attribute of the cell tag */
    public static final String VERTICALALIGN = "verticalalign";
    
/** attribute of the cell tag */
    public static final String COLSPAN = "colspan";
    
/** attribute of the cell tag */
    public static final String ROWSPAN = "rowspan";
    
/** attribute of the cell tag */
    public static final String HEADER = "header";
    
/** attribute of the cell tag */
    public static final String NOWRAP = "nowrap";
    
/** attribute of the table/cell tag */
    public static final String BORDERWIDTH = "borderwidth";
    
/** attribute of the table/cell tag */
    public static final String TOP = "top";
    
/** attribute of the table/cell tag */
    public static final String BOTTOM = "bottom";
    
/** attribute of the table/cell tag */
    public static final String WIDTH = "width";
    
/** attribute of the table/cell tag */
    public static final String BORDERCOLOR = "bordercolor";
    
/** attribute of the table/cell tag */
    public static final String BACKGROUNDCOLOR = "backgroundcolor";
    
/** attribute of the table/cell tag */
    public static final String BGRED = "bgred";
    
/** attribute of the table/cell tag */
    public static final String BGGREEN = "bggreen";
    
/** attribute of the table/cell tag */
    public static final String BGBLUE = "bgblue";
    
/** attribute of the table/cell tag */
    public static final String GRAYFILL = "grayfill";
    
    // Misc
    
/** the image tag */
    public static final String IMAGE = "image";
    
/** attribute of the image and annotation tag */
    public static final String URL = "url";
    
/** attribute of the image tag */
    public static final String UNDERLYING = "underlying";
    
/** attribute of the image tag */
    public static final String TEXTWRAP = "textwrap";
    
/** attribute of the image tag */
    public static final String ALT = "alt";
    
/** attribute of the image tag */
    public static final String ABSOLUTEX = "absolutex";
    
/** attribute of the image tag */
    public static final String ABSOLUTEY = "absolutey";
    
/** attribute of the image tag */
    public static final String PLAINWIDTH = "plainwidth";
    
/** attribute of the image tag */
    public static final String PLAINHEIGHT = "plainheight";
    
/** attribute of the image tag */
    public static final String SCALEDWIDTH = "scaledwidth";
    
/** attribute of the image tag */
    public static final String SCALEDHEIGHT = "scaledheight";
    
/** attribute of the image tag */
    public static final String  ROTATION = "rotation";
    
/** the newpage tag */
    public static final String NEWPAGE = "newpage";
    
/** the newpage tag */
    public static final String NEWLINE = "newline";
    
/** the annotation tag */
    public static final String ANNOTATION = "annotation";
    
/** attribute of the annotation tag */
    public static String FILE = "file";
    
/** attribute of the annotation tag */
    public static String DESTINATION = "destination";
    
/** attribute of the annotation tag */
    public static String PAGE = "page";
    
/** attribute of the annotation tag */
    public static String NAMED = "named";
    
/** attribute of the annotation tag */
    public static String APPLICATION = "application";
    
/** attribute of the annotation tag */
    public static String PARAMETERS = "parameters";
    
/** attribute of the annotation tag */
    public static String OPERATION = "operation";
    
/** attribute of the annotation tag */
    public static String DEFAULTDIR = "defaultdir";
    
/** attribute of the annotation tag */
    public static String LLX = "llx";
    
/** attribute of the annotation tag */
    public static String LLY = "lly";
    
/** attribute of the annotation tag */
    public static String URX = "urx";
    
/** attribute of the annotation tag */
    public static String URY = "ury";
    
/** attribute of the annotation tag */
    public static final String CONTENT = "content";

/** attribute for specifying externally defined CSS class (only recognized by HTML generator) */
    public static final String CLASS = "class";
    
    // alignment attribute values
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_LEFT = "Left";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_CENTER = "Center";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_RIGHT = "Right";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_JUSTIFIED = "Justify";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_TOP = "Top";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_MIDDLE = "Middle";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_BOTTOM = "Bottom";
    
/** the possible value of an alignment attribute */
    public static final String ALIGN_BASELINE = "Baseline";
    
/** the possible value of an alignment attribute */
    public static final String DEFAULT = "Default";
    
/** the possible value of an alignment attribute */
    public static final String UNKNOWN = "unknown";
    
/** the possible value of a font */
    public static final String COURIER = "Courier";
    
/** the possible value of a font */
    public static final String HELVETICA = "Helvetica";
    
/** the possible value of a font */
    public static final String TIMES_NEW_ROMAN = "Times New Roman";
    
/** the possible value of a font */
    public static final String SYMBOL = "Symbol";
    
/** the possible value of a font */
    public static final String ZAPFDINGBATS = "ZapfDingBats";
    
/** the possible value of a fontstyle */
    public static final String NORMAL = "normal";
    
/** the possible value of a fontstyle */
    public static final String ITALIC = "italic";
    
/** the possible value of a fontstyle */
    public static final String BOLD = "bold";
    
/** the possible value of a fontstyle */
    public static final String UNDERLINE = "underline";
    
/** the possible value of a fontstyle */
    public static final String STRIKETHRU = "strike";
    
/** the possible value of a page-break */
    public static final String ALWAYS = "always";
    
/** the possible value of a tag */
    public static final String HORIZONTALRULE = "horizontalrule";
    
    // methods
    
/**
 * Translates the alignment value.
 *
 * @param   alignment   the alignment value
 * @return  the translated value
 */
    
    public static String getAlignment(int alignment) {
        switch(alignment) {
            case Element.ALIGN_LEFT:
                return ALIGN_LEFT;
            case Element.ALIGN_CENTER:
                return ALIGN_CENTER;
            case Element.ALIGN_RIGHT:
                return ALIGN_RIGHT;
            case Element.ALIGN_JUSTIFIED:
                return ALIGN_JUSTIFIED;
            case Element.ALIGN_TOP:
                return ALIGN_TOP;
            case Element.ALIGN_MIDDLE:
                return ALIGN_MIDDLE;
            case Element.ALIGN_BOTTOM:
                return ALIGN_BOTTOM;
            case Element.ALIGN_BASELINE:
                return ALIGN_BASELINE;
                default:
                    return DEFAULT;
        }
    }
    
/**
 * Converts a <CODE>Color</CODE> into a HTML representation of this <CODE>Color</CODE>.
 *
 * @param	color	the <CODE>Color</CODE> that has to be converted.
 * @return	the HTML representation of this <COLOR>Color</COLOR>
 */
    
    public static Color decodeColor(String string) {
        int red = 0;
        int green = 0;
        int blue = 0;
        try {
            red = Integer.parseInt(string.substring(1, 3), 16);
            green = Integer.parseInt(string.substring(3, 5), 16);
            blue = Integer.parseInt(string.substring(5), 16);
        }
        catch(Exception sioobe) {
            // empty on purpose
        }
        return new Color(red, green, blue);
    }
    
}

