package org.telegram.api.functions.auth;

import org.telegram.api.auth.TLAuthorization;
import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;
import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request auth sign up.
 */
public class TLRequestAuthSignUp extends TLMethod<TLAuthorization> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x1b067634;

    private String phoneNumber;
    private String phoneCodeHash;
    private String phoneCode;
    private String firstName;
    private String lastName;

    /**
     * Instantiates a new TL request auth sign up.
     */
    public TLRequestAuthSignUp() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLAuthorization deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null)
            throw new IOException("Unable to parse response");
        if ((res instanceof TLAuthorization))
            return (TLAuthorization) res;
        throw new IOException("Incorrect response type. Expected org.telegram.api.auth.TLAuthorization, got: " + res.getClass().getCanonicalName());
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param value the value
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets phone code hash.
     *
     * @return the phone code hash
     */
    public String getPhoneCodeHash() {
        return this.phoneCodeHash;
    }

    /**
     * Sets phone code hash.
     *
     * @param value the value
     */
    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    /**
     * Gets phone code.
     *
     * @return the phone code
     */
    public String getPhoneCode() {
        return this.phoneCode;
    }

    /**
     * Sets phone code.
     *
     * @param value the value
     */
    public void setPhoneCode(String value) {
        this.phoneCode = value;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets first name.
     *
     * @param value the value
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets last name.
     *
     * @param value the value
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLString(this.phoneNumber, stream);
        StreamingUtils.writeTLString(this.phoneCodeHash, stream);
        StreamingUtils.writeTLString(this.phoneCode, stream);
        StreamingUtils.writeTLString(this.firstName, stream);
        StreamingUtils.writeTLString(this.lastName, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.phoneNumber = StreamingUtils.readTLString(stream);
        this.phoneCodeHash = StreamingUtils.readTLString(stream);
        this.phoneCode = StreamingUtils.readTLString(stream);
        this.firstName = StreamingUtils.readTLString(stream);
        this.lastName = StreamingUtils.readTLString(stream);
    }

    public String toString() {
        return "auth.signUp#1b067634";
    }
}