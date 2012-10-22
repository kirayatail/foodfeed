/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller;

import edu.chl.dat076.foodfeed.mock.Model;
import edu.chl.dat076.foodfeed.model.dao.IUserDao;
import edu.chl.dat076.foodfeed.model.dao.MockUserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import java.beans.PropertyEditor;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author max
 */
public class UserControllerTest {
    
    MockUserDao userDao;
    UserController uc;
    public UserControllerTest() {
        userDao = new MockUserDao();
    }
    
    @Before
    public void buildUp(){
        userDao.create(new User("adam", "bertil"));
        userDao.create(new User("bertil", "cesar"));
        uc = new UserController();
        ReflectionTestUtils.setField(uc, "userDao", userDao, IUserDao.class);
    }
    
    @After
    public void tearDown(){
        userDao.clear();
    }
    
    @Test
    public void testCreate(){
        Model model = new Model();
    }
    
}

class Result implements BindingResult {
    
    public ObjectError error;

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
        throw new UnsupportedOperationException("Not supported yet.");
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