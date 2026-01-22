```xml
<select id="findAll" parameterType="person" resultType="person">
    SELECT id,name,age FROM person
    <where>
        <if test="name =! null">
            name = #{name}
        </if>
        <if test="age =! null">
            and age = #{age}
        </if>
    </where>
</select>


<update id="update" parameterType="person">
UPDATE person
<set>
    <if test="name =! null">
        name = #{name},
    </if>
    <if test="age =! null">
        age=#{age},
    </if>
</set>
WHERE id = #{id}
</update>

<delete id="deleteArray" parameterType="integer">
DELETE FROM person WHERE id IN
<foreach collection="array" item="id" open="(" close=")" separator=",">
    #{id}
</foreach>
</delete>

<delete id="deleteList" parameterType="integer">
DELETE FROM person WHERE id IN
<foreach collection="list" item="id" open="(" close=")" separator=",">
    #{id}
</foreach>
</delete>

<delete id="deleteMap" parameterType="Map">
DELETE FROM person WHERE id IN
<foreach collection="ids" item="id" open="(" close=")" separator=",">
    #{id}
</foreach>
AND age = #{age}
</delete>
```

