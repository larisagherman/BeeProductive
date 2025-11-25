package com.beeproductive.backend.service;

import com.beeproductive.backend.dto.MemberDetailsRequestDto;
import com.beeproductive.backend.dto.MemberDetailsResponseDto;
import com.beeproductive.backend.entity.Group;
import com.beeproductive.backend.entity.MemberDetails;
import com.beeproductive.backend.entity.MemberKey;
import com.beeproductive.backend.entity.User;
import com.beeproductive.backend.mapper.MemberDetailsMapper;
import com.beeproductive.backend.repository.GroupRepository;
import com.beeproductive.backend.repository.MemberDetailsRepository;
import com.beeproductive.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MemberDetailsService {
    private final MemberDetailsRepository memberDetailsRepository;
    private final MemberDetailsMapper memberDetailsMapper;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    public void addMember(Long userId,Long groupId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        MemberKey key = new MemberKey(userId, groupId);

        // Prevent duplicates
        if (memberDetailsRepository.existsById(key)) {
            throw new RuntimeException("User is already a member of this group");
        }

        MemberDetails member = new MemberDetails();
        member.setId(key);
        member.setUser(user);
        member.setGroup(group);
        member.setKgOfHoney(0);
        memberDetailsRepository.save(member);
    }
    public MemberDetailsResponseDto getMemberDetailsByMemberKey(MemberKey memberKey) {
        MemberDetails memberDetails=memberDetailsRepository.findById(memberKey).orElseThrow(()-> new RuntimeException("Member not found!"));
        return memberDetailsMapper.memberDetailsToMemberDetailsResponseDto(memberDetails);
    }
    public List<MemberDetailsResponseDto> getAllMemberDetails() {
        List<MemberDetails> memberDetailsList=memberDetailsRepository.findAll();
        return memberDetailsMapper.memberDetailsToMemberDetailsResponseDtoList(memberDetailsList);
    }
    public void removeMember(Long userId,Long groupId) {
        MemberKey key = new MemberKey(userId, groupId);

        MemberDetails member = memberDetailsRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("Member not found!"));

        memberDetailsRepository.delete(member);
    }

}
