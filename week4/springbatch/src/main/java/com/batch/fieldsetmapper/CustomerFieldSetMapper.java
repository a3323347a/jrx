package com.batch.fieldsetmapper;

import com.batch.entity.Customer;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 将文件记录映射成客户类
 */
public class CustomerFieldSetMapper implements FieldSetMapper<Customer> {

    @Override
    public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
        Customer customer = new Customer();
        customer.setCustid(fieldSet.readInt("custid"));
        customer.setSurname(fieldSet.readString("surname"));
        customer.setGender(fieldSet.readString("gender"));
        customer.setEducades(fieldSet.readString("educades"));
        customer.setMardes(fieldSet.readString("mardes"));
        customer.setAge(fieldSet.readInt("age"));
        customer.setAddress(fieldSet.readString("address"));
        return customer;
    }
}
