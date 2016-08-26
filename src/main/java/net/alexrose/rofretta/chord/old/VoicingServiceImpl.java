package net.alexrose.rofretta.chord.old;

/**
 *
 * @author  Alex
 * @version
 */
public abstract class VoicingServiceImpl implements VoicingService {
   /*private VoicingDao dao;
    
 
    public void setDao(VoicingDao dao){
        this.dao = dao;
    }

    public void saveVoicing(Voicing voicing) {
        voicing.validate();
        
    }

    public void deleteVoicing(Voicing voicing) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Voicing[] findVoicing(VoicingSearchCriteria spec) {
        spec.validate();
        
        ArrayList<Voicing> returnValues = new ArrayList();
        VoicingType specifiedVoicing = spec.getVoicingType();
        NoteName specifiedRoot = spec.getRoot();
        
        //1st, look up open chords, since they are simplest 
        if(specifiedVoicing == null  || VoicingType.OPEN == specifiedVoicing) {
            
            //even if spec asked for all types, force to open for this lookup
            //since movable chord types need to be processed differently
            spec.setVoicingType(VoicingType.OPEN);
            
            Voicing[] searchResults = dao.loadVoicings(spec);
            if(searchResults != null && searchResults.length > 0)
                Collections.addAll(returnValues, searchResults);
        }
        
        //now lookup up the movable stuff if requested - 
        for(VoicingType movableType: new VoicingType[]{VoicingType.BAR, VoicingType.MOVABLE_SHAPE}) {
            
            if(specifiedVoicing == null || movableType == specifiedVoicing) {
                //blank out the root so we get all possibilities
                //and force
                spec.setRoot(null);
                spec.setVoicingType(movableType);
                
                Voicing[] searchResults = dao.loadVoicings(spec);
                
                //now, walk through the set and see if we 
                //can transpose to desired root
                if(searchResults != null) {
                    for(Voicing voicing : searchResults) {
                        try {
                            voicing.transpose(specifiedRoot);
                            returnValues.add(voicing);
                        }
                        catch (ParameterException e) {
                            //a failure here should mean we couldn't transpose the
                            //chord to the desired root - just ignore and move to
                            //the next one
                        }
                    }
                }
                
            }
        }
        
        return returnValues.toArray(new Voicing[returnValues.size()]);
    } */
}
