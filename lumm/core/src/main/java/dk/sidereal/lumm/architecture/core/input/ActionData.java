/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 ******************************************************************************/

package dk.sidereal.lumm.architecture.core.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import dk.sidereal.lumm.architecture.core.Input;

/**
 * Represents the data related to one input action ( key, mouse button or
 * finger). Is created if it does not exist whenever the input listener detects
 * the action has been used. If an instance for a specific action has not been
 * created and the data for that input action is requested by the user via
 * {@link Input#getInputData(int)}, an instance is created and added to the
 * input system.
 *
 * @author Claudiu Bele
 */
public class ActionData {

    // region fields

    /**
     * keyCode assigned based on {@link Keys} or {@link Buttons}. If the input
     * is of type touch, the code will be the pointer passed in
     * {@link InputProcessor#touchDown(int, int, int, int)} and
     * {@link InputProcessor#touchUp(int, int, int, int)}.
     */
    public int code;

    /** The status of the input */
    public Input.InputStatus inputStatus;

    /** The time at which {@link #inputStatus} has changed. */
    protected float statusTimestamp;

    // endregion fields

    // region constructors

    public ActionData(int code) {

        this.code = code;
        this.inputStatus = Input.InputStatus.None;
    }

    public void update(Input.InputStatus status) {

        if (this.inputStatus != status) {
            this.statusTimestamp = System.currentTimeMillis();
            this.inputStatus = status;
        }
    }

    /**
     * Returns a human-readable string representation of the input code, using
     * {@link Input.Action#toString(int)}
     */
    @Override
    public String toString() {
        return Input.Action.toString(code);
    }

    // endregion constructors

    // region methods

    // region getters/setters

    public int getCode() {

        return code;
    }

    public Input.InputStatus getInputStatus() {

        return inputStatus;
    }

    void setInputStatus(Input.InputStatus inputStatus) {

        this.inputStatus = inputStatus;
    }

    // endregion getters/setters

    // endregion methods

}
