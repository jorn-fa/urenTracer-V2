package jorn.hiel.urentracker.service.dto;

import jorn.hiel.urentracker.service.managers.WorkhourManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthDto {

    private String day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31;
    private String worked1,worked2,worked3,worked4,worked5,worked6,worked7,worked8,worked9,worked10,worked11,worked12,worked13,worked14,worked15,worked16,worked17,worked18,worked19,worked20,worked21,worked22,worked23,worked24,worked25,worked26,worked27,worked28,worked29,worked30,worked31;
    private String extra1,extra2,extra3,extra4,extra5,extra6,extra7,extra8,extra9,extra10,extra11,extra12,extra13,extra14,extra15,extra16,extra17,extra18,extra19,extra20,extra21,extra22,extra23,extra24,extra25,extra26,extra27,extra28,extra29,extra30,extra31;
    private boolean toLow1,toLow2,toLow3,toLow4,toLow5,toLow6,toLow7,toLow8,toLow9,toLow10,toLow11,toLow12,toLow13,toLow14,toLow15,toLow16,toLow17,toLow18,toLow19,toLow20,toLow21,toLow22,toLow23,toLow24,toLow25,toLow26,toLow27,toLow28,toLow29,toLow30,toLow31;

    private String shouldWorkMinutes,shouldWorkHours;
    private String workedMinutes,workedHours;
    private String difference;

    WorkhourManager manager= new WorkhourManager();
    void test(){
        //manager.
    }

}
