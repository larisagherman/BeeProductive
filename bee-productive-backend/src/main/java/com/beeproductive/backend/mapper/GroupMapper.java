package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.GroupRequestDto;
import com.beeproductive.backend.dto.GroupResponseDto;
import com.beeproductive.backend.entity.Challenge;
import com.beeproductive.backend.entity.Group;
import com.beeproductive.backend.entity.MemberDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    Group requestDtoToGroup(GroupRequestDto groupRequestDto);
    @Mapping(target="userAdmin",source="userAdmin.id")
    @Mapping(target="challengeIds", expression = "java(mapChallengeSetToIds(group.getChallengeList()))")
    @Mapping(target="memberData", expression = "java(mapMemberDetailsSetToIds(group.getMemberData()))")
    GroupResponseDto groupToResponseDto(Group group);
    List<GroupResponseDto> groupToResponseDtoList(List<Group> groups);
    default Set<Long> mapChallengeSetToIds(Set<Challenge> challenges) {
        if (challenges == null) return null;
        return challenges.stream().map(Challenge::getId).collect(Collectors.toSet());
    }

    default Set<Long> mapMemberDetailsSetToIds(Set<MemberDetails> members) {
        if (members == null) return null;
        return members.stream().map(m -> m.getId().getUserId()).collect(Collectors.toSet());
    }
}
