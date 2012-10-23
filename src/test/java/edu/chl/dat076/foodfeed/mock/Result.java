package edu.chl.dat076.foodfeed.mock;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 *
 * @author max
 */
public class Result implements BindingResult {
    
    public boolean hasErrors;
    

    @Override
    public Object getTarget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Object> getModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getRawFieldValue(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PropertyEditor findEditor(String string, Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PropertyEditorRegistry getPropertyEditorRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addError(ObjectError oe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] resolveMessageCodes(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] resolveMessageCodes(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void recordSuppressedField(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getSuppressedFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getObjectName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNestedPath(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNestedPath() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pushNestedPath(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void popNestedPath() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reject(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reject(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reject(String string, Object[] os, String string1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rejectValue(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rejectValue(String string, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void rejectValue(String string, String string1, Object[] os, String string2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addAllErrors(Errors errors) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasErrors() {
        return this.hasErrors;
    }

    @Override
    public int getErrorCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ObjectError> getAllErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasGlobalErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getGlobalErrorCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ObjectError> getGlobalErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ObjectError getGlobalError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasFieldErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getFieldErrorCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FieldError> getFieldErrors() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FieldError getFieldError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasFieldErrors(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getFieldErrorCount(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FieldError> getFieldErrors(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FieldError getFieldError(String string) {
        return new FieldError(string, string, string) {
            public String getDefaultMessage(){
                return "OK";
            }
        };
    }

    @Override
    public Object getFieldValue(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class<?> getFieldType(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}