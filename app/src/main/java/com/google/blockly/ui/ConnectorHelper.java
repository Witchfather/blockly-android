/*
 * Copyright  2015 Google Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.blockly.ui;

import android.graphics.Path;

/**
 * Helper class for drawing block connectors.
 */
public class ConnectorHelper {
    // The offset between a connector and the closest corner, in dips.
    static final int OFFSET_FROM_CORNER = 20;
    // The size of a connector perpendicular to the block boundary, in dips.
    static final int SIZE_PERPENDICULAR = 20;
    // The size of a connector parallel to the block boundary, in dips.
    static final int SIZE_PARALLEL = 40;

    // The minimum width of a Statement input connector to the right of its fields.
    static final int STATEMENT_INPUT_INDENT_WIDTH = 4 * SIZE_PARALLEL;
    // Height (i.e., thickness) of the bottom of a C-shaped Statement input connector.
    static final int STATEMENT_INPUT_BOTTOM_HEIGHT = SIZE_PERPENDICULAR;

    static final int OPEN_INLINE_CONNECTOR_WIDTH = 80;
    static final int OPEN_INLINE_CONNECTOR_HEIGHT = 80;

    /**
     * Add a "Previous" connector to the block's draw path.
     * <p/>
     * The reference point for this connector is the top-left corner of the block.
     *
     * @param blockLeft Horizontal view coordinate of the left-hand side of the block (right-hand
     *                  side in RTL mode).
     * @param blockTop Vertical view coordinate of the top of the block.
     */
    static void addPreviousConnectorToPath(Path path, int blockLeft, int blockTop) {
        int x = blockLeft + OFFSET_FROM_CORNER;
        path.lineTo(x, blockTop);
        path.lineTo(x, blockTop + SIZE_PERPENDICULAR);

        x += SIZE_PARALLEL;
        path.lineTo(x, blockTop + SIZE_PERPENDICULAR);
        path.lineTo(x, blockTop);
    }

    /**
     * Add a "Next" connector to the block's draw path.
     *
     * @param blockLeft Horizontal view coordinate of the left-hand side of the block (right-hand
     *                  side in RTL mode).
     * @param blockBottom Vertical view coordinate of the bottom of the block.
     */
    static void addNextConnectorToPath(Path path, int blockLeft, int blockBottom) {
        int x = blockLeft + OFFSET_FROM_CORNER + SIZE_PARALLEL;
        path.lineTo(x, blockBottom);
        path.lineTo(x, blockBottom + SIZE_PERPENDICULAR);

        x -= SIZE_PARALLEL;
        path.lineTo(x, blockBottom + SIZE_PERPENDICULAR);
        path.lineTo(x, blockBottom);
    }

    /**
     * Add a Value input connector to the block's draw path.
     *
     * @param blockRight Horizontal view coordinate of the right-hand side of the block (left-hand
     *                   side in RTL mode).
     * @param inputTop Vertical view coordinate of the top of the input for which this connector is
     *                 drawn.
     */
    static void addValueInputConnectorToPath(Path path, int blockRight, int inputTop) {
        int y = inputTop + OFFSET_FROM_CORNER;
        path.lineTo(blockRight, y);
        path.lineTo(blockRight - SIZE_PERPENDICULAR, y);

        y += SIZE_PARALLEL;
        path.lineTo(blockRight - SIZE_PERPENDICULAR, y);
        path.lineTo(blockRight, y);
    }

    /**
     * Add a Statement input connector to the block's draw path.
     *
     * @param blockRight Horizontal view coordinate of the right-hand side of the block (left-hand
     *                   side in RTL mode).
     * @param inputTop Vertical view coordinate of the top of the InputView for which this connector
     *                 is drawn.
     * @param xOffset The offset of the Statement input connector from the left (or right, in RTL
     *                mode) boundary of the block.
     * @param inputHeight The height of the connected input block(s).
     */
    static void addStatementInputConnectorToPath(
            Path path, int blockRight, int inputTop, int xOffset, int inputHeight) {
        path.lineTo(blockRight, inputTop);

        int x = xOffset + OFFSET_FROM_CORNER + SIZE_PARALLEL;
        path.lineTo(x, inputTop);
        path.lineTo(x, inputTop + SIZE_PERPENDICULAR);

        x -= SIZE_PARALLEL;
        path.lineTo(x, inputTop + SIZE_PERPENDICULAR);
        path.lineTo(x, inputTop);

        path.lineTo(xOffset, inputTop);
        path.lineTo(xOffset, inputTop + inputHeight);
        path.lineTo(blockRight, inputTop + inputHeight);
    }

    /**
     * Add an "Output" connector to the block's draw path.
     *
     * @param blockLeft Horizontal view coordinate of the left-hand side of the block (right-hand
     *                  side in RTL mode).
     * @param blockBottom Vertical view coordinate of the bottom of the block.
     */
    static void addOutputConnectorToPath(Path path, int blockLeft, int blockBottom) {
        int y = blockBottom + OFFSET_FROM_CORNER + SIZE_PARALLEL;
        path.lineTo(blockLeft, y);
        path.lineTo(blockLeft - SIZE_PERPENDICULAR, y);

        y -= SIZE_PARALLEL;
        path.lineTo(blockLeft - SIZE_PERPENDICULAR, y);
        path.lineTo(blockLeft, y);
    }
}