package ru.math.tversu.studentapp.model.object;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import ru.math.tversu.studentapp.model.user.StudyGroup;

@Entity
@Data
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToMany
  private List<ScheduleItem> items;

  @ManyToOne
  @JoinColumn(name = "study_group_id")
  private StudyGroup studyGroup;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "week_type")
  public WeekType weekType;

  public enum WeekType {
    MINUS,
    PLUS
  }
}
