package Hogwarts.serviceimpl;

import Hogwarts.entity.Comment;
import Hogwarts.entity.Daka;
import Hogwarts.repository.CommentRepository;
import Hogwarts.repository.DakaRepository;
import Hogwarts.repository.ScenicSpotRepository;
import Hogwarts.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DakaRepository dakaRepository;
    @Autowired
    private ScenicSpotRepository scenicSpotRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public String create(int uid, Date stime, Date etime) {
        //System.out.println(stime);
        //System.out.println(etime);
        String text = "";
        List<Daka> rec = dakaRepository.findbydate(uid,stime,etime);
        if (rec.size()==0) return "No Data";
        boolean f = false;
        for (Daka i : rec) {
            String s = "";
            Date d = i.getTime();
            int sid = i.getSid();
            Comment com = commentRepository.findbysuid(i.getSid(),i.getUid());

            //时间
            if (!f) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                System.out.println(d);
                System.out.println(cal);
                int mon = cal.get(Calendar.MONTH)+1;
                System.out.println(mon);
                if (mon >= 2 && mon <= 4) text = "所谓三月三日气象新，长安水边多丽人。" +
                        "万木吐翠，芳草茵茵，百鸟争鸣，阳光和熙，空气清新，春天正是出门游玩的好时节。\n";
                else if (mon >= 5 && mon <= 7) text = "要么读书，要么旅行，身体和灵魂总有一个在路上。\n";
                else if (mon >= 8 && mon <= 10) text = "碧云天，黄叶地，秋色连波，波上寒烟翠。一带江山如画，景物向秋潇洒，秋日的每一天都适合外出游逛。\n";
                else if (mon >= 11 || mon == 1) text = "注定要去的地方，多晚都有光。\n";
                f = true;
            }
            s += String.format(Locale.CHINA,"%tB",d)+String.format(Locale.CHINA,"%te号",d)+","+
                    String.format(Locale.CHINA,"%tA",d)+",";

            //地点
            s += "我去了" + scenicSpotRepository.findById(sid).get().getName() + "。";

            //描述
            String pro = scenicSpotRepository.findById(sid).get().getProfile();
            while (pro.startsWith(" ")) pro = pro.substring(1);
            System.out.println(pro);
            s += pro;

            //感受
            if (com.getGrade()==4) s += "还不错。";
            else if (com.getGrade()==3) s += "感觉一般。";
            else if (com.getGrade()==2) s += "体验比较差。";
            else if (com.getGrade()==1) s += "太差了！rnm，退钱！";
            else s += "来到这里真的非常棒！";
            text += s + "\n";
        }
        return text;
    }
}
