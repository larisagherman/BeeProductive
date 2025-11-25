package com.beeproductive.backend.service;

import com.beeproductive.backend.dto.GroupRequestDto;
import com.beeproductive.backend.dto.GroupResponseDto;
import com.beeproductive.backend.entity.*;
import com.beeproductive.backend.mapper.GroupMapper;
import com.beeproductive.backend.repository.ChallengeRepository;
import com.beeproductive.backend.repository.GroupRepository;
import com.beeproductive.backend.repository.MemberDetailsRepository;
import com.beeproductive.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final ChallengeRepository challengeRepository;
    private final GroupMapper groupMapper;
    private final MemberDetailsRepository memberDetailsRepository;

    public void createGroup(GroupRequestDto groupRequestDto) {
        User adminUser=userRepository.findById(groupRequestDto.getAdminId()).orElseThrow(()->new RuntimeException("Admin for this group not found!"));

        Group group=new Group();
        group.setUserAdmin(adminUser);
        group.setName(groupRequestDto.getName());

        if(!groupRequestDto.getChallengeIds().isEmpty()) {
            Set<Challenge> challenges=new HashSet<>(challengeRepository.findAllById(groupRequestDto.getChallengeIds()));
            group.setChallengeList(challenges);
        }

        if(!groupRequestDto.getMembersIds().isEmpty()) {
            for(Long memberId : groupRequestDto.getMembersIds()) {
                User member=userRepository.findById(memberId).orElse(null);

                MemberDetails memberDetails=new MemberDetails();
                memberDetails.setGroup(group);
                memberDetails.setUser(member);
                memberDetails.setKgOfHoney(10);
            }
        }
        groupRepository.save(group);
    }
    public List<GroupResponseDto> getAllGroups() {
        List<Group> groups=groupRepository.findAll();
        return groupMapper.groupToResponseDtoList(groups);
    }
    public GroupResponseDto getGroupById(Long id) {
        Group group=groupRepository.findById(id).orElseThrow(()->new RuntimeException("Group not found!"));
        return groupMapper.groupToResponseDto(group);
    }
    public void deleteGroupById(Long id) {
        Group group=groupRepository.findById(id).orElseThrow(()->new RuntimeException("Group not found!"));
        groupRepository.delete(group);
    }
    public void updateGroupDetailsByGroupId(Long id, GroupRequestDto groupRequestDto) {
        Group group=groupRepository.findById(id).orElseThrow(()->new RuntimeException("Group not found!"));
        group.setName(groupRequestDto.getName());
        if(!groupRequestDto.getChallengeIds().isEmpty()) {
            Set<Challenge> challenges=new HashSet<>(challengeRepository.findAllById((groupRequestDto.getChallengeIds())));
            for(Challenge challenge:challenges) {
                challenge.getGroupList().add(group);
            }
            group.setChallengeList(challenges);
        }
        groupRepository.save(group);
    }
    public void updateGroupMembersByGroupId(Long id, GroupRequestDto groupRequestDto) {
        Group group=groupRepository.findById(id).orElseThrow(()->new RuntimeException("Group not found!"));
        if(!groupRequestDto.getMembersIds().isEmpty()) {
            /*
            Set<MemberDetails> members=new HashSet<>(memberDetailsRepository.findAllById((groupRequestDto.getMembersIds())));
            for(MemberDetails challenge:challenges) {
                challenge.getGroupList().add(group);
            }
            group.setChallengeList(challenges);

             */
        }
        groupRepository.save(group);
    }

}
