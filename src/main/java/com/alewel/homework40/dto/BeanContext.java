package com.alewel.homework40.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "beans")
public class BeanContext {

    @Id
    private Long id;

    private String name;
    private String scope;
    private boolean isSingleton;

    public BeanContext() {
    }

    public BeanContext(Long id, String name, String scope, boolean isSingletone) {
        this.id = id;
        this.name = name;
        this.scope = scope;
        this.isSingleton = isSingletone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanContext that = (BeanContext) o;
        return isSingleton == that.isSingleton &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, scope, isSingleton);
    }

    @Override
    public String toString() {
        return "BeanContext{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                ", isSingleton=" + isSingleton +
                '}';
    }
}
