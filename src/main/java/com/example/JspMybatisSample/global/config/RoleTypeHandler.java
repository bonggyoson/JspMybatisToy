package com.example.JspMybatisSample.global.config;

import com.example.JspMybatisSample.domain.member.Role;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(Role.class)
public class RoleTypeHandler implements TypeHandler<Role> {

    @Override
    // 지정된 타입의 어떤 값을 DB에 저장
    public void setParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter.getKey());
    }

    @Override
    // 컬럼 이름 기반으로 조회된 값을 활용해서 실제 반환할 객체 구성
    public Role getResult(ResultSet rs, String columnName) throws SQLException {
        String roleKey = rs.getString(columnName);
        return getRole(roleKey);
    }

    @Override
    // 컬럼 index 기반으로 조회된 값을 활용해서 실제 반환할 객체 구성
    public Role getResult(ResultSet rs, int columnIndex) throws SQLException {
        String roleKey = rs.getString(columnIndex);
        return getRole(roleKey);
    }

    @Override
    // Callablestatement에서 컬럼 index 기반으로 조회된 값을 활용해서 실제 반환할 객체 구성
    public Role getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String roleKey = cs.getString(columnIndex);
        return getRole(roleKey);
    }

    // 실제 객체를 구성하는 메서드
    private Role getRole(String roleKey) {
        Role role = null;
        switch (roleKey) {
            case "ROLE_ADMIN":
                role = Role.ROLE_ADMIN;
                break;
            case "ROLE_MEMBER":
                role = Role.ROLE_MEMBER;
                break;
            default:
                break;
        }

        return role;
    }
}
