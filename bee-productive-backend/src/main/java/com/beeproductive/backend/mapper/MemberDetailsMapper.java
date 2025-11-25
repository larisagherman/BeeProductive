package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.MemberDetailsResponseDto;
import com.beeproductive.backend.entity.MemberDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberDetailsMapper {
    @Mapping(target = "memberKey.userId",source="user.id")
    @Mapping(target = "memberKey.groupId",source="group.id")
    MemberDetailsResponseDto memberDetailsToMemberDetailsResponseDto(MemberDetails memberDetails);
    List<MemberDetailsResponseDto> memberDetailsToMemberDetailsResponseDtoList(List<MemberDetails> memberDetails);


}
