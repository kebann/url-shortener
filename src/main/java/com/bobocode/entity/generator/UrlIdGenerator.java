package com.bobocode.entity.generator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UrlIdGenerator
    implements IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor,
      Object o) throws HibernateException {
    return randomAlphanumeric(7);
  }
}