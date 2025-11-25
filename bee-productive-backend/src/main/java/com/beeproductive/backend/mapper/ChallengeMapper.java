package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.ChallengeResponseDto;
import com.beeproductive.backend.entity.Challenge;
import com.beeproductive.backend.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {
    @Mapping(target="groupList", expression = "java(mapGroupsSetToIds(challenge.getGroupList()))")
    ChallengeResponseDto challengeToChallengeResponseDto(Challenge challenge);
    List<ChallengeResponseDto> challengeToChallengeResponseDtoList(List<Challenge> challenges);

    default Set<Long> mapGroupsSetToIds(Set<Group> groups) {
        if (groups == null) return null;
        return groups.stream().map(Group::getId).collect(Collectors.toSet());
    }
}
