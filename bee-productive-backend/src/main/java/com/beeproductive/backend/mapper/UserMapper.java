package com.beeproductive.backend.mapper;

import com.beeproductive.backend.dto.UserRequestDto;
import com.beeproductive.backend.dto.UserResponseDto;
import com.beeproductive.backend.entity.Group;
import com.beeproductive.backend.entity.MemberDetails;
import com.beeproductive.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
uses = {ScreenTimeMapper.class})
public interface UserMapper {
    User requestDtoToUser(UserRequestDto userRequestDto);
    @Mapping(target="screenTimes",source="screenTimes")
    @Mapping(target = "adminGroups", expression = "java(mapGroupsToIds(user.getAdminGroups()))")
    @Mapping(target = "groupData", expression = "java(mapMemberDetailsToIds(user.getGroupData()))")
    UserResponseDto userToDtoResponse(User user);
    List<UserResponseDto> usersToDtoResponses(List<User> users);

    default Set<Long> mapGroupsToIds(Set<Group> groups) {
        if (groups == null) return null;
        return groups.stream()
                .map(Group::getId)
                .collect(Collectors.toSet());
    }

    default Set<Long> mapMemberDetailsToIds(Set<MemberDetails> members) {
        Set<Long> result = null;
        if (members != null) {
            result = members.stream()
                    .map(m -> m.getId().getUserId()) // or whatever you want to expose
                    .collect(Collectors.toSet());// or whatever you want to expose
        }
        return result;
    }
}
