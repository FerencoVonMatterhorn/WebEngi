package main.java.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.java.pojos.GroupPojo;

@NoArgsConstructor
@Getter
@Setter
public class GroupOverViewBean {

	private List<GroupPojo> groups = new ArrayList<>();

}
