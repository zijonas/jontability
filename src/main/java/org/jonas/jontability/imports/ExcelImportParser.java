package org.jonas.jontability.imports;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jonas.jontability.dto.PostDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ExcelImportParser {

    public static Map<String, List<PostDto>> readLines(FileReader fr, int year) throws IOException {
        Map<String, List<PostDto>> parsedLines = Maps.newHashMap();
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null && !line.isEmpty()) {
            Map.Entry<String, List<PostDto>> stringListEntry = readLine(line, year);
            assert stringListEntry != null;
            parsedLines.put(stringListEntry.getKey(), stringListEntry.getValue());
            line = br.readLine();
        }
        return parsedLines;
    }

    private static Map.Entry<String, List<PostDto>> readLine(String line, int year) {
        StringTokenizer stk = new StringTokenizer(line, ";");
        String account = (String) stk.nextElement();
        if(account != null && !account.isEmpty()) {
            return new AbstractMap.SimpleEntry<>(account, readValues(stk, year));
        } else {
            return null;
        }
    }

    private static List<PostDto> readValues(StringTokenizer stk, int year) {
        List<PostDto> newPosts = Lists.newArrayList();
        int month = 0;
        while (stk.hasMoreElements() && month <= Calendar.DECEMBER) {
            Object element = stk.nextElement();
            if (element != null) {
                newPosts.add(createPost(element, month, year));
            }
            month++;
        }
        return newPosts;
    }

    private static PostDto createPost(Object element, int month, int year) {
        PostDto postDto = new PostDto();
        postDto.setCategoryId(155);//TODO dynamic
        postDto.setDate(new GregorianCalendar(year, month ,1).getTime());
        postDto.setValue(Double.parseDouble(((String) element).replace(',', '.')));
        return postDto;
    }

}
